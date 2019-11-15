package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Subtask;

@Repository
public class SubtaskDAOImpl implements SubtaskDAO 
{
	
	private EntityManager entityManager;
	
	
	public SubtaskDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public List<Subtask> getAllSubtasks() 
	{
		Session currentSession = entityManager.unwrap(Session.class);
	
		
		Query<Subtask> theQuery = currentSession.createQuery("from Subtask s where s.taskId = (SELECT taskId from Task where projectId =(SELECT projectId from ProjectMember where employeeId= 1))",
				Subtask.class);
		
		
		List<Subtask> subtasks = theQuery.getResultList();
					
		return subtasks;
	}

}
