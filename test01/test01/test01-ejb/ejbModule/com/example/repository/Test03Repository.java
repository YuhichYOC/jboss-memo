/*
 *
 * Test03Repository.java
 *
 * Copyright 2025 Yuichi Yoshii
 *     吉井雄一 @ 吉井産業  you.65535.kir@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.example.repository;

import com.example.entity.Test03;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;

import java.util.List;

@ApplicationScoped
public class Test03Repository {

    @PersistenceContext(unitName = "MyAppPU")
    private EntityManager entityManager;

    public List<Test03> findAll() {
        String jpql = "SELECT t FROM Test03 t";
        return entityManager.createQuery(jpql, Test03.class).getResultList();
    }
}