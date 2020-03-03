// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.appengine.api.datastore.*;
<<<<<<< HEAD
import com.google.gson.*;
=======
import com.google.gson.Gson;
>>>>>>> 938c2c3e12f97becd762dd1b5123b76f4a042617
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
    public ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> comments = new ArrayList<String>();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //Query
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    Query query = new Query("Task");

    PreparedQuery results = datastore.prepare(query);

    List<String> tasks = new ArrayList<>();
    for (Entity entity : results.asIterable()) {
      long id = entity.getKey().getId();
      String comment = (String) entity.getProperty("comment");
    
      String task = comment;
      tasks.add(task);
    }

    Gson gson = new GsonBuilder().serializeNulls().create();
    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(tasks));
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the input from the form.
    String text = getParameter(request, "comment-input", "");

    // adds to stored list of comments
    comments.add(text);

    //Datastore
    String commentText = request.getParameter("comment-input");

    Entity commentEntity = new Entity("Task");
    commentEntity.setProperty("comment", commentText);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(commentEntity);

    response.sendRedirect("/index.html");
  }

  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }
}
