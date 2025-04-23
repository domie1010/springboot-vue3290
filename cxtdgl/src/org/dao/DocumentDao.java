package org.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.entity.Document;
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
public class DocumentDao extends HibernateDaoSupport {

	@Autowired
	protected void initDao(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Document findById(java.lang.String id) {
		return getHibernateTemplate().get(Document.class, id);
	}

	public List<Document> findList(Document entity, int start, int limit) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			
			
			if (StringUtils.isNotEmpty(entity.getContent())) {
				criteria.add(Restrictions.like("content", entity.getContent(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getIstop())) {
				criteria.add(Restrictions.eq("istop", entity.getIstop()));
			}

			
			if (StringUtils.isNotEmpty(entity.getTitle())) {
				criteria.add(Restrictions.like("title", entity.getTitle(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getChannelName())) {
				criteria.add(Restrictions.like("channelName", entity.getChannelName(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getChannel())) {
				criteria.add(Restrictions.eq("channel", entity.getChannel()));
			}
			
			if (StringUtils.isNotEmpty(entity.getChannelType())) {
				criteria.add(Restrictions.eq("channelType", entity.getChannelType()));
			}

					
						
			/**********************************************************************/
		}
		criteria.addOrder(Order.desc("createtime"));
		return getHibernateTemplate().findByCriteria(criteria, start, limit);
	}

	public List<Document> findAllList(Document entity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			if (StringUtils.isNotEmpty(entity.getContent())) {
				criteria.add(Restrictions.like("content", entity.getContent(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getIstop())) {
				criteria.add(Restrictions.like("istop", entity.getIstop(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getTitle())) {
				criteria.add(Restrictions.like("title", entity.getTitle(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getChannelName())) {
				criteria.add(Restrictions.like("channelName", entity.getChannelName(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getChannel())) {
				criteria.add(Restrictions.like("channel", entity.getChannel(), MatchMode.ANYWHERE));
			}		
			/**********************************************************************/
		}
		criteria.addOrder(Order.desc("istop"));
		return getHibernateTemplate().findByCriteria(criteria);
	}

	public int countList(Document entity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entity.getClass());
		if (entity != null) {
			/**********************************************************************/
			if (StringUtils.isNotEmpty(entity.getContent())) {
				criteria.add(Restrictions.like("content", entity.getContent(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getIstop())) {
				criteria.add(Restrictions.like("istop", entity.getIstop(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getTitle())) {
				criteria.add(Restrictions.like("title", entity.getTitle(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getChannelName())) {
				criteria.add(Restrictions.like("channelName", entity.getChannelName(), MatchMode.ANYWHERE));
			}

			
			if (StringUtils.isNotEmpty(entity.getChannel())) {
				criteria.add(Restrictions.like("channel", entity.getChannel(), MatchMode.ANYWHERE));
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
			Document entity = findById(id);
			if (entity != null) {
				getHibernateTemplate().delete(entity);
				return true;
			}
		}
		return false;
	}

	public boolean update(Document entity) {
		try {
			if (entity != null && StringUtils.isNotEmpty(entity.getId())) {
				Document updateEntity = findById(entity.getId());
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