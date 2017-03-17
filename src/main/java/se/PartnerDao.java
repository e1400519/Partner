package se;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/*
 * Class implements DAO (data access object) method to CRUD POJO to database
 */
public class PartnerDao {
	private Partner dao;

	public Partner getDao() {
		return dao;
	}

	public void setDao(Partner dao) {
		this.dao = dao;
	}

	private EntityManager entityManager;

	public void init() {
		entityManager = Persistence
				.createEntityManagerFactory("se")
				.createEntityManager();
	}

	public List<Partner> getDaos() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createNamedQuery("Partner.findAll");
		// Query query = entityManager.createQuery("from Product c",
		// Product.class);
		List<Partner> result = query.getResultList();
		entityManager.getTransaction().commit();
		return result;
	}

	public int persist(Partner dao) {
		entityManager.getTransaction().begin();
		entityManager.persist(dao);
		entityManager.getTransaction().commit();
		return dao.getCompanyId();
	}

	public void initialize(int daoNumber) {
		dao = entityManager.find(Partner.class, daoNumber);
		if (dao == null)
			throw new IllegalStateException("Dao number (" + daoNumber
					+ ") not found");
	}

	public void update(Partner _dao) {
		// just checking that the dao really has is
		if (dao.getCompanyId() > 0) {
			// get the actual entity from database to a dao-named attribute
			initialize(dao.getCompanyId());
			// start database transaction
			entityManager.getTransaction().begin();
			dao.setCompany(_dao.getCompany());
			dao.setEmail(_dao.getEmail());
			dao.setDesc(_dao.getDesc());
			entityManager.merge(dao);
			entityManager.getTransaction().commit();
		}
	}

	public void delete() {
		entityManager.getTransaction().begin();
		entityManager.remove(dao);
		entityManager.getTransaction().commit();
	}

	public void destroy() {
		entityManager.close();
	}
}
