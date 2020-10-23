package com.qhw.demo.mapper;

import com.qhw.demo.domain.Police;

public interface PoliceMapper {
    Police selectPoliceByUsername(String username);
}
