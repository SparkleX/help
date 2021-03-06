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

import org.apache.olingo.odata2.api.ODataCallback;
import org.apache.olingo.odata2.api.ODataDebugCallback;
import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.api.commons.HttpStatusCodes;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.exception.ODataApplicationException;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataErrorCallback;
import org.apache.olingo.odata2.api.processor.ODataErrorContext;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.processor.ODataResponse.ODataResponseBuilder;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;

public class CarServiceFactory extends ODataServiceFactory {

  @Override
  public ODataService createService(final ODataContext ctx) throws ODataException {

    EdmProvider edmProvider = new CarEdmProvider();

    ODataSingleProcessor singleProcessor = new CarODataSingleProcessor();

    return createODataSingleProcessorService(edmProvider, singleProcessor);
  }
  
  @Override
  public <T extends ODataCallback> T getCallback(final Class<T> callbackInterface) 
  {
	  if(callbackInterface.equals(ODataDebugCallback.class))
	  {
		  ODataDebugCallback debugCallBack = new ODataDebugCallback() {
			@Override
			public boolean isDebugEnabled() {
				return true;
			}};
			return (T) debugCallBack;
	  }
	  
	  if(callbackInterface.equals(ODataErrorCallback.class))
	  {
		  ODataErrorCallback callback = new ODataErrorCallback() {

			@Override
			public ODataResponse handleError(ODataErrorContext context) throws ODataApplicationException 
			{
				context.getException().printStackTrace();
				
				return EntityProvider.writeErrorDocument(context);
				
			}};
			return (T) callback;
	  }
	  return null;
  }
}
