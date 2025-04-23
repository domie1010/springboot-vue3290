package org.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.entity.Log;
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
public class LogDao extends HibernateDaoSupport {

	@Autowired
	protected void initDao(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Log findById(java.lang.String id) {
		return getHibernateTemplate().get(Log.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Log> findList(Log entity, int start, int limit) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			//MatchMode.ANYWHERE
						
			if (StringUtils.isNotEmpty(entity.getMessage())) {
				criteria.add(Restrictions.eq("message", entity.getMessage()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getId())) {
				criteria.add(Restrictions.eq("id", entity.getId()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getUsername())) {
				criteria.add(Restrictions.eq("username", entity.getUsername()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getUserid())) {
				criteria.add(Restrictions.eq("userid", entity.getUserid()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getOpip())) {
				criteria.add(Restrictions.eq("opip", entity.getOpip()));
			}
			
															
			/**********************************************************************/
		}
		criteria.addOrder(Order.desc("createtime"));
		return getHibernateTemplate().findByCriteria(criteria, start, limit);
	}
	
	@SuppressWarnings("unchecked")
	public List<Log> findAllList(Log entity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			
						if (StringUtils.isNotEmpty(entity.getMessage())) {
				criteria.add(Restrictions.eq("message", entity.getMessage()));
			}
						if (StringUtils.isNotEmpty(entity.getId())) {
				criteria.add(Restrictions.eq("id", entity.getId()));
			}
						if (StringUtils.isNotEmpty(entity.getUsername())) {
				criteria.add(Restrictions.eq("username", entity.getUsername()));
			}
						if (StringUtils.isNotEmpty(entity.getUserid())) {
				criteria.add(Restrictions.eq("userid", entity.getUserid()));
			}
						if (StringUtils.isNotEmpty(entity.getOpip())) {
				criteria.add(Restrictions.eq("opip", entity.getOpip()));
			}
												
			/**********************************************************************/
		}
		criteria.addOrder(Order.desc("createtime"));
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
	public int countList(Log entity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			
			
			if (StringUtils.isNotEmpty(entity.getMessage())) {
				criteria.add(Restrictions.eq("message", entity.getMessage()));
			}

			
			if (StringUtils.isNotEmpty(entity.getId())) {
				criteria.add(Restrictions.eq("id", entity.getId()));
			}

			
			if (StringUtils.isNotEmpty(entity.getUsername())) {
				criteria.add(Restrictions.eq("username", entity.getUsername()));
			}

			
			if (StringUtils.isNotEmpty(entity.getUserid())) {
				criteria.add(Restrictions.eq("userid", entity.getUserid()));
			}

			
			if (StringUtils.isNotEmpty(entity.getOpip())) {
				criteria.add(Restrictions.eq("opip", entity.getOpip()));
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
		return 0;
	}

	public boolean delete(String id) {
		if (StringUtils.isNotEmpty(id)) {
			Log entity = findById(id);
			if (entity != null) {
				getHibernateTemplate().delete(entity);
				return true;
			}
		}
		return false;
	}

	public boolean update(Log entity) {
		try {
			if (entity != null && StringUtils.isNotEmpty(entity.getId())) {
				Log updateEntity = findById(entity.getId());
				entity.setCreatetime(updateEntity.getCreatetime());
				PropertyUtils.copyProperties(updateEntity, entity);
				getHibernateTemplate().update(updateEntity);
			} else {
				entity.setCreatetime(new Date());
				getHibernateTemplate().save(entity);
			}
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return false;
	}
}