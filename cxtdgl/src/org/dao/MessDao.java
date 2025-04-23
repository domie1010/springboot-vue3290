package org.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.entity.Mess;
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
public class MessDao extends HibernateDaoSupport {

	@Autowired
	protected void initDao(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Mess findById(java.lang.String id) {
		return getHibernateTemplate().get(Mess.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Mess> findList(Mess entity, int start, int limit) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			//MatchMode.ANYWHERE
						
			if (StringUtils.isNotEmpty(entity.getFusername())) {
				criteria.add(Restrictions.eq("fusername", entity.getFusername()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getId())) {
				criteria.add(Restrictions.eq("id", entity.getId()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getFmessage())) {
				criteria.add(Restrictions.eq("fmessage", entity.getFmessage()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getExt1())) {
				criteria.add(Restrictions.eq("ext1", entity.getExt1()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getExt2())) {
				criteria.add(Restrictions.eq("ext2", entity.getExt2()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getFuserid())) {
				criteria.add(Restrictions.eq("fuserid", entity.getFuserid()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getExt3())) {
				criteria.add(Restrictions.eq("ext3", entity.getExt3()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getTusername())) {
				criteria.add(Restrictions.eq("tusername", entity.getTusername()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getTmessage())) {
				criteria.add(Restrictions.eq("tmessage", entity.getTmessage()));
			}
			
						
			if (StringUtils.isNotEmpty(entity.getTuserid())) {
				criteria.add(Restrictions.eq("tuserid", entity.getTuserid()));
			}
			
															
			/**********************************************************************/
		}
		criteria.addOrder(Order.desc("createtime"));
		return getHibernateTemplate().findByCriteria(criteria, start, limit);
	}
	
	@SuppressWarnings("unchecked")
	public List<Mess> findAllList(Mess entity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			
						if (StringUtils.isNotEmpty(entity.getFusername())) {
				criteria.add(Restrictions.eq("fusername", entity.getFusername()));
			}
						if (StringUtils.isNotEmpty(entity.getId())) {
				criteria.add(Restrictions.eq("id", entity.getId()));
			}
						if (StringUtils.isNotEmpty(entity.getFmessage())) {
				criteria.add(Restrictions.eq("fmessage", entity.getFmessage()));
			}
						if (StringUtils.isNotEmpty(entity.getExt1())) {
				criteria.add(Restrictions.eq("ext1", entity.getExt1()));
			}
						if (StringUtils.isNotEmpty(entity.getExt2())) {
				criteria.add(Restrictions.eq("ext2", entity.getExt2()));
			}
						if (StringUtils.isNotEmpty(entity.getFuserid())) {
				criteria.add(Restrictions.eq("fuserid", entity.getFuserid()));
			}
						if (StringUtils.isNotEmpty(entity.getExt3())) {
				criteria.add(Restrictions.eq("ext3", entity.getExt3()));
			}
						if (StringUtils.isNotEmpty(entity.getTusername())) {
				criteria.add(Restrictions.eq("tusername", entity.getTusername()));
			}
						if (StringUtils.isNotEmpty(entity.getTmessage())) {
				criteria.add(Restrictions.eq("tmessage", entity.getTmessage()));
			}
						if (StringUtils.isNotEmpty(entity.getTuserid())) {
				criteria.add(Restrictions.eq("tuserid", entity.getTuserid()));
			}
												
			/**********************************************************************/
		}
		criteria.addOrder(Order.desc("createtime"));
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
	public int countList(Mess entity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			
			
			if (StringUtils.isNotEmpty(entity.getFusername())) {
				criteria.add(Restrictions.eq("fusername", entity.getFusername()));
			}

			
			if (StringUtils.isNotEmpty(entity.getId())) {
				criteria.add(Restrictions.eq("id", entity.getId()));
			}

			
			if (StringUtils.isNotEmpty(entity.getFmessage())) {
				criteria.add(Restrictions.eq("fmessage", entity.getFmessage()));
			}

			
			if (StringUtils.isNotEmpty(entity.getExt1())) {
				criteria.add(Restrictions.eq("ext1", entity.getExt1()));
			}

			
			if (StringUtils.isNotEmpty(entity.getExt2())) {
				criteria.add(Restrictions.eq("ext2", entity.getExt2()));
			}

			
			if (StringUtils.isNotEmpty(entity.getFuserid())) {
				criteria.add(Restrictions.eq("fuserid", entity.getFuserid()));
			}

			
			if (StringUtils.isNotEmpty(entity.getExt3())) {
				criteria.add(Restrictions.eq("ext3", entity.getExt3()));
			}

			
			if (StringUtils.isNotEmpty(entity.getTusername())) {
				criteria.add(Restrictions.eq("tusername", entity.getTusername()));
			}

			
			if (StringUtils.isNotEmpty(entity.getTmessage())) {
				criteria.add(Restrictions.eq("tmessage", entity.getTmessage()));
			}

			
			if (StringUtils.isNotEmpty(entity.getTuserid())) {
				criteria.add(Restrictions.eq("tuserid", entity.getTuserid()));
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
			Mess entity = findById(id);
			if (entity != null) {
				getHibernateTemplate().delete(entity);
				return true;
			}
		}
		return false;
	}

	public boolean update(Mess entity) {
		try {
			if (entity != null && StringUtils.isNotEmpty(entity.getId())) {
				Mess updateEntity = findById(entity.getId());
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