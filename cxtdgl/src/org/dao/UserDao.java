package org.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.commons.beanutils.PropertyUtils;

@Repository
public class UserDao extends HibernateDaoSupport {

	@Autowired
	protected void initDao(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public User findById(java.lang.String id) {
		try {
			return getHibernateTemplate().get(User.class, id);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public User findByUserName(User entity) {
		try {
			if (entity != null && StringUtils.isNotEmpty(entity.getUsername())) {
				DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
				criteria.add(Restrictions.eq("username", entity.getUsername()));
				List<User> userEntityList = getHibernateTemplate().findByCriteria(criteria);
				if (userEntityList.size() > 0) {
					return userEntityList.get(0);
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<?> findList(User entity, int start, int limit) {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
			if (entity != null) {
				/**********************************************************************/
				if (StringUtils.isNotEmpty(entity.getUsername())) {
					criteria.add(Restrictions.like("username", entity.getUsername(), MatchMode.ANYWHERE));
				}
				/**********************************************************************/
			}
			criteria.addOrder(Order.desc("createtime"));
			return getHibernateTemplate().findByCriteria(criteria, start, limit);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<?> findList(User entity) {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
			if (entity != null) {
				/**********************************************************************/
				if (StringUtils.isNotEmpty(entity.getUsername())) {
					criteria.add(Restrictions.like("username", entity.getUsername(), MatchMode.ANYWHERE));
				}
				if (StringUtils.isNotEmpty(entity.getType())) {
					criteria.add(Restrictions.eq("type", entity.getType()));
				}
				/**********************************************************************/
			}
			criteria.addOrder(Order.desc("createtime"));
			return getHibernateTemplate().findByCriteria(criteria);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int countList(User entity) {

		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
			if (entity != null) {
				/**********************************************************************/
				if (StringUtils.isNotEmpty(entity.getUsername())) {
					criteria.add(Restrictions.like("username", entity.getUsername(), MatchMode.ANYWHERE));
				}
				/**********************************************************************/
			}
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.count("id"));
			criteria.setProjection(projList);
			HibernateTemplate hibernateTemplate = getHibernateTemplate();
			List<?> countList = hibernateTemplate.findByCriteria(criteria);
			if (!countList.isEmpty()) {
				return Integer.parseInt(countList.get(0) + "");
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void delete(String id) {
		try {
			if (StringUtils.isNotEmpty(id)) {
				User entity = findById(id);
				if (entity != null)
					getHibernateTemplate().delete(entity);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	public void update(User entity) {
		try {
			if (entity != null && StringUtils.isNotEmpty(entity.getId())) {
				User updateEntity = findById(entity.getId());
				entity.setCreatetime(updateEntity.getCreatetime());
				PropertyUtils.copyProperties(updateEntity, entity);
				getHibernateTemplate().update(updateEntity);
			} else {
				entity.setCreatetime(new Date());
				getHibernateTemplate().save(entity);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	public int countListByUserName(User entity) {

		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
			if (entity != null) {
				/**********************************************************************/
				if (StringUtils.isNotEmpty(entity.getUsername())) {
					criteria.add(Restrictions.eq("username", entity.getUsername()));
				}
				/**********************************************************************/
			}
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.count("id"));
			criteria.setProjection(projList);
			HibernateTemplate hibernateTemplate = getHibernateTemplate();
			List<?> countList = hibernateTemplate.findByCriteria(criteria);
			if (!countList.isEmpty()) {
				return Integer.parseInt(countList.get(0) + "");
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}
}