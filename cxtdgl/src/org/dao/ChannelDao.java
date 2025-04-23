package org.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.entity.Channel;
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
public class ChannelDao extends HibernateDaoSupport {

	@Autowired
	protected void initDao(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Channel findById(java.lang.String id) {
		return getHibernateTemplate().get(Channel.class, id);
	}

	public List<Channel> findList(Channel entity, int start, int limit) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			if (StringUtils.isNotEmpty(entity.getCparentName())) {
				criteria.add(Restrictions.like("cparentName", entity.getCparentName(), MatchMode.ANYWHERE));
			}
			
			if (StringUtils.isNotEmpty(entity.getIsshow())) {
				criteria.add(Restrictions.like("isshow", entity.getIsshow(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getCtype())) {
				criteria.add(Restrictions.like("ctype", entity.getCtype(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getCparent())) {
				criteria.add(Restrictions.like("cparent", entity.getCparent(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getCname())) {
				criteria.add(Restrictions.like("cname", entity.getCname(), MatchMode.ANYWHERE));
			}
		
			/**********************************************************************/
		}
		criteria.addOrder(Order.asc("csort"));
		return getHibernateTemplate().findByCriteria(criteria, start, limit);
	}

	public List<Channel> findAllList(Channel entity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			if (StringUtils.isNotEmpty(entity.getCparentName())) {
				criteria.add(Restrictions.like("cparentName", entity.getCparentName(), MatchMode.ANYWHERE));
			}
			
			if (StringUtils.isNotEmpty(entity.getIsshow())) {
				criteria.add(Restrictions.like("isshow", entity.getIsshow(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getCtype())) {
				criteria.add(Restrictions.like("ctype", entity.getCtype(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getCparent())) {
				criteria.add(Restrictions.like("cparent", entity.getCparent(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getCname())) {
				criteria.add(Restrictions.like("cname", entity.getCname(), MatchMode.ANYWHERE));
			}
						
			/**********************************************************************/
		}
		criteria.addOrder(Order.asc("csort"));
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public int countList(Channel entity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/

			if (StringUtils.isNotEmpty(entity.getCparentName())) {
				criteria.add(Restrictions.like("cparentName", entity.getCparentName(), MatchMode.ANYWHERE));
			}
			
			if (StringUtils.isNotEmpty(entity.getIsshow())) {
				criteria.add(Restrictions.like("isshow", entity.getIsshow(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getCtype())) {
				criteria.add(Restrictions.like("ctype", entity.getCtype(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getCparent())) {
				criteria.add(Restrictions.like("cparent", entity.getCparent(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getCname())) {
				criteria.add(Restrictions.like("cname", entity.getCname(), MatchMode.ANYWHERE));
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
			Channel entity = findById(id);
			if (entity != null) {
				getHibernateTemplate().delete(entity);
				return true;
			}
		}
		return false;
	}

	public boolean update(Channel entity) {
		try {
			if (entity != null && StringUtils.isNotEmpty(entity.getId())) {
				Channel updateEntity = findById(entity.getId());
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