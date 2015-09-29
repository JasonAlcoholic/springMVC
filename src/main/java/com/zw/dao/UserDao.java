package com.zw.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zw.entity.User;
@Repository
public class UserDao extends BaseDao{
	
	public List<User> getAllUsers(){
        String hsql="from users";
        return runSql(hsql);
    }
	
	public List<User> getByName(String name){
        String hsql="from users where name = '" + name + "'";
        return runSql(hsql);
    }
	
	/*@Autowired
	private MongoOperations mongoTemplate;
	
    public void insert(User user) {  
        mongoTemplate.insert(user);  
    }  
      
    public void insertAll(List<User> users) {  
        mongoTemplate.insertAll(users);  
    }  
      
    public void deleteById(String id) {  
        User user = new User(id, null, 0);  
        mongoTemplate.remove(user);  
    }  
      
    public void delete(User criteriaUser) {  
        Criteria criteria = Criteria.where("age").gt(criteriaUser.getAge());;  
        Query query = new Query(criteria);  
        mongoTemplate.remove(query, User.class);  
    }  
      
    public void deleteAll() {  
        mongoTemplate.dropCollection(User.class);  
    }  
      
    public void updateById(User user) {  
        Criteria criteria = Criteria.where("id").is(user.getId());  
        Query query = new Query(criteria);  
        Update update = Update.update("age", user.getAge()).set("name", user.getName());  
        mongoTemplate.updateFirst(query, update, User.class);  
    }  
      
    public void update(User criteriaUser, User user) {  
        Criteria criteria = Criteria.where("age").gt(criteriaUser.getAge());;  
        Query query = new Query(criteria);  
        Update update = Update.update("name", user.getName()).set("age", user.getAge());  
        mongoTemplate.updateMulti(query, update, User.class);  
    }  
      
    public User findById(String id) {  
        return mongoTemplate.findById(id, User.class);  
    }  
      
    public List<User> findAll() {  
        return mongoTemplate.findAll(User.class);  
    }  
      
    public List<User> find(User criteriaUser, int skip, int limit) {  
        Query query = getQuery(criteriaUser);  
        query.skip(skip);  
        query.limit(limit);  
        return mongoTemplate.find(query, User.class);  
    }  
      
    public User findAndModify(User criteriaUser, User updateUser) {  
        Query query = getQuery(criteriaUser);  
        Update update = Update.update("age", updateUser.getAge()).set("name", updateUser.getName());  
        return mongoTemplate.findAndModify(query, update, User.class);  
    }  
    
    public User findAndRemove(User criteriaUser) {  
        Query query = getQuery(criteriaUser);  
        return mongoTemplate.findAndRemove(query, User.class);  
    }  
      
    public long count(User criteriaUser) {  
        Query query = getQuery(criteriaUser);  
        return mongoTemplate.count(query, User.class);  
    }  
  
    private Query getQuery(User criteriaUser) {  
        if (criteriaUser == null) {  
            criteriaUser = new User();  
        }  
        Query query = new Query();  
        if (criteriaUser.getId() != null) {  
            Criteria criteria = Criteria.where("id").is(criteriaUser.getId());  
            query.addCriteria(criteria);  
        }  
        if (criteriaUser.getAge() > 0) {  
            Criteria criteria = Criteria.where("age").gt(criteriaUser.getAge());  
            query.addCriteria(criteria);  
        }  
        if (criteriaUser.getName() != null) {  
            Criteria criteria = Criteria.where("name").regex("^" + criteriaUser.getName());  
            query.addCriteria(criteria);  
        }  
        return query;  
    }  */
}  