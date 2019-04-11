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
    
    @Cacheable(key="'person'")
    public Person getUserById(String i) {
        return repoPerson.findById(i).get();
    }

    @CachePut(key="'person'")
    public Person update(Person user) {
        return repoPerson.save(user);
    }
 
    @CacheEvict(key="'person'")
    public String del(String i) {
        repoPerson.deleteById(i);
        return "deleted";
    }
}