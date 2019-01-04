/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package help;

import static help.CarEdmProvider.ENTITY_SET_NAME_CARS;
import static help.CarEdmProvider.ENTITY_SET_NAME_MANUFACTURERS;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata2.api.batch.BatchHandler;
import org.apache.olingo.odata2.api.batch.BatchRequestPart;
import org.apache.olingo.odata2.api.batch.BatchResponsePart;
import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.apache.olingo.odata2.api.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.edm.EdmLiteral;
import org.apache.olingo.odata2.api.edm.EdmLiteralKind;
import org.apache.olingo.odata2.api.edm.EdmProperty;
import org.apache.olingo.odata2.api.edm.EdmSimpleType;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.EntityProviderBatchProperties;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties.ODataEntityProviderPropertiesBuilder;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.exception.ODataNotFoundException;
import org.apache.olingo.odata2.api.exception.ODataNotImplementedException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.api.uri.KeyPredicate;
import org.apache.olingo.odata2.api.uri.PathInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntitySetUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetEntityUriInfo;
import org.apache.olingo.odata2.api.uri.info.GetFunctionImportUriInfo;

public class CarODataSingleProcessor extends ODataSingleProcessor {

  private final CarDataStore dataStore;

  public CarODataSingleProcessor() {
    dataStore = new CarDataStore();
  }

  @Override
  public ODataResponse readEntitySet(final GetEntitySetUriInfo uriInfo, final String contentType) 
      throws ODataException {

	  
    EdmEntitySet entitySet;

    EdmFunctionImport function = uriInfo.getFunctionImport();
    if(function!=null)
    {
    	EdmLiteral lit = uriInfo.getFunctionImportParameters().get("test");
    	lit.getLiteral();
    	entitySet = function.getEntitySet();
    	return EntityProvider.writeFeed(contentType, entitySet, dataStore.getCars(),
    			EntityProviderWriteProperties.serviceRoot(getContext().getPathInfo().getServiceRoot()).build());
    }
    if (uriInfo.getNavigationSegments().size() == 0) {
      entitySet = uriInfo.getStartEntitySet();

      if (ENTITY_SET_NAME_CARS.equals(entitySet.getName())) {
        return EntityProvider.writeFeed(contentType, entitySet, dataStore.getCars(),
            EntityProviderWriteProperties.serviceRoot(getContext().getPathInfo().getServiceRoot()).build());
      } else if (ENTITY_SET_NAME_MANUFACTURERS.equals(entitySet.getName())) {
        return EntityProvider.writeFeed(contentType, entitySet, dataStore.getManufacturers(),
            EntityProviderWriteProperties.serviceRoot(getContext().getPathInfo().getServiceRoot()).build());
      }

      throw new ODataNotFoundException(ODataNotFoundException.ENTITY);

    } else if (uriInfo.getNavigationSegments().size() == 1) {
      // navigation first level, simplified example for illustration purposes only
      entitySet = uriInfo.getTargetEntitySet();

      if (ENTITY_SET_NAME_CARS.equals(entitySet.getName())) {
        int manufacturerKey = getKeyValue(uriInfo.getKeyPredicates().get(0));

        List<Map<String, Object>> cars = new ArrayList<Map<String, Object>>();
        cars.addAll(dataStore.getCarsFor(manufacturerKey));

        return EntityProvider.writeFeed(contentType, entitySet, cars, EntityProviderWriteProperties.serviceRoot(
            getContext().getPathInfo().getServiceRoot()).build());
      }

      throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
    }

    throw new ODataNotImplementedException();
  }

  @Override
  public ODataResponse readEntity(final GetEntityUriInfo uriInfo, final String contentType) throws ODataException {

    if (uriInfo.getNavigationSegments().size() == 0) {
      EdmEntitySet entitySet = uriInfo.getStartEntitySet();

      if (ENTITY_SET_NAME_CARS.equals(entitySet.getName())) {
        int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
        Map<String, Object> data = dataStore.getCar(id);

        if (data != null) {
          URI serviceRoot = getContext().getPathInfo().getServiceRoot();
          ODataEntityProviderPropertiesBuilder propertiesBuilder =
              EntityProviderWriteProperties.serviceRoot(serviceRoot);

          return EntityProvider.writeEntry(contentType, entitySet, data, propertiesBuilder.build());
        }
      } else if (ENTITY_SET_NAME_MANUFACTURERS.equals(entitySet.getName())) {
        int id = getKeyValue(uriInfo.getKeyPredicates().get(0));
        Map<String, Object> data = dataStore.getManufacturer(id);

        if (data != null) {
          URI serviceRoot = getContext().getPathInfo().getServiceRoot();
          ODataEntityProviderPropertiesBuilder propertiesBuilder =
              EntityProviderWriteProperties.serviceRoot(serviceRoot);

          return EntityProvider.writeEntry(contentType, entitySet, data, propertiesBuilder.build());
        }
      }

      throw new ODataNotFoundException(ODataNotFoundException.ENTITY);

    } else if (uriInfo.getNavigationSegments().size() == 1) {
      // navigation first level, simplified example for illustration purposes only
      EdmEntitySet entitySet = uriInfo.getTargetEntitySet();

      Map<String, Object> data = null;

      if (ENTITY_SET_NAME_MANUFACTURERS.equals(entitySet.getName())) {
        int carKey = getKeyValue(uriInfo.getKeyPredicates().get(0));
        data = dataStore.getManufacturerFor(carKey);
      }

      if (data != null) {
        return EntityProvider.writeEntry(contentType, uriInfo.getTargetEntitySet(),
            data, EntityProviderWriteProperties.serviceRoot(getContext().getPathInfo().getServiceRoot()).build());
      }

      throw new ODataNotFoundException(ODataNotFoundException.ENTITY);
    }

    throw new ODataNotImplementedException();
  }
  @Override
  public ODataResponse executeFunctionImport(final GetFunctionImportUriInfo uriInfo, final String contentType)
      throws ODataException 
  {
      URI serviceRoot = getContext().getPathInfo().getServiceRoot();
      ODataEntityProviderPropertiesBuilder propertiesBuilder =
          EntityProviderWriteProperties.serviceRoot(serviceRoot);

	  EdmFunctionImport functionImport = uriInfo.getFunctionImport();
	  return EntityProvider.writeFunctionImport("application/xml;charset=utf-8", functionImport, new Integer(135), propertiesBuilder.build());
  }
  
  @Override
  public ODataResponse executeFunctionImportValue(final GetFunctionImportUriInfo uriInfo, final String contentType)
      throws ODataException {
      URI serviceRoot = getContext().getPathInfo().getServiceRoot();
      ODataEntityProviderPropertiesBuilder propertiesBuilder =
          EntityProviderWriteProperties.serviceRoot(serviceRoot);

	  EdmFunctionImport functionImport = uriInfo.getFunctionImport();
	  return EntityProvider.writeText("135");

  }
  private int getKeyValue(final KeyPredicate key) throws ODataException {
    EdmProperty property = key.getProperty();
    EdmSimpleType type = (EdmSimpleType) property.getType();
    return type.valueOfString(key.getLiteral(), EdmLiteralKind.DEFAULT, property.getFacets(), Integer.class);
  }
  
  @Override
  public ODataResponse executeBatch(final BatchHandler handler, final String contentType, final InputStream content)
      throws ODataException {

    List<BatchResponsePart> batchResponseParts = new ArrayList<BatchResponsePart>();
    PathInfo pathInfo = getContext().getPathInfo();
    EntityProviderBatchProperties batchProperties = EntityProviderBatchProperties.init().pathInfo(pathInfo).build();
    List<BatchRequestPart> batchParts = EntityProvider.parseBatchRequest(contentType, content, batchProperties);
    for (BatchRequestPart batchPart : batchParts) {
      batchResponseParts.add(handler.handleBatchPart(batchPart));
    }
    return EntityProvider.writeBatchResponse(batchResponseParts);
  }
}
