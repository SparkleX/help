package help.redis.spring.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames="persons")
public class PersonService  {

    @Autowired
    private PersonRepository repoPerson;
    
    @Cacheable(key="#id")
    public Person getUserById(String id) {
        return repoPerson.findById(id).get();
    }

    @CachePut(key="#user.id")
    public Person update(Person user) {
        return repoPerson.save(user);
    }
 
    @CacheEvict(key="#id")
    public String remove(String id) {
        repoPerson.deleteById(id);
        return "deleted";
    }
}