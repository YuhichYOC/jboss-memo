/*
 *
 * Test03.java
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
package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "test03_usdjpy_test04")
public class Test03 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "opened")
    private java.util.Date opened;

    @Column(name = "closed")
    private java.util.Date closed;

    @Column(name = "profit")
    private Double profit;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getOpened() {
        return opened;
    }
    public void setOpened(java.util.Date opened) {
        this.opened = opened;
    }

    public java.util.Date getClosed() {
        return closed;
    }
    public void setClosed(java.util.Date closed) {
        this.closed = closed;
    }

    public Double getProfit() {
        return profit;
    }
    public void setProfit(Double profit) {
        this.profit = profit;
    }
}