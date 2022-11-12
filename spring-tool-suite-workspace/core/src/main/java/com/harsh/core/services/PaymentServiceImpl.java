package com.harsh.core.services;

import org.springframework.stereotype.Service;

import com.harsh.core.dao.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentDAO {

	private PaymentDAO dao;

	public PaymentDAO getDao() {
		return dao;
	}

	public void setDao(PaymentDAO dao) {
		this.dao = dao;
	}
}
