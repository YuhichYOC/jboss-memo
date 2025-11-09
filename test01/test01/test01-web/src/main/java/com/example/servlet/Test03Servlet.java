/*
 *
 * Test03Servlet.java
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
package com.example.servlet;

import com.example.repository.Test03Repository;
import com.example.entity.Test03;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/test03")
public class Test03Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private Test03Repository test03Repository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Test03> test03List = test03Repository.findAll();
        req.setAttribute("test03List", test03List);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/test03.jsp");
        dispatcher.forward(req, resp);
    }
}