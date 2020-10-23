package com.qhw.demo.service;

import com.qhw.demo.domain.Police;
import com.qhw.demo.domain.User;

import java.util.List;

public interface PoliceService {
    Police selectPoliceByUsername(String username);
}
