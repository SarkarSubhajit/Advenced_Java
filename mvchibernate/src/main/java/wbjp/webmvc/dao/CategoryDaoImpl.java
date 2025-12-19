package wbjp.webmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import wbjp.webmvc.entity.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory hibernateFactory;

	@Override
	public Category findById(int catId) {

		try (Session hibernateSession = hibernateFactory.openSession()) {
			Query query = hibernateSession.createQuery("select OBJECT(oCat) from Category oCat where categoryId=?",
					Category.class);
			query.setParameter(1, catId);

			try {
				return (Category) query.getSingleResult();
			} catch (NoResultException e) {
				return new Category();
			}
		}
	}

	@Override
	public List<Category> findAll() {
		
		try (Session hibernateSession = hibernateFactory.openSession()) {
			Query query = hibernateSession.createQuery("from Category", Category.class);
			
			List<Category> list = query.getResultList();
			
			return list;
		}
	}

}
