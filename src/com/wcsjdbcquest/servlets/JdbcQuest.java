package com.wcsjdbcquest.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wcsjdbcquest.bdd.Authors;
import com.wcsjdbcquest.bdd.JediMaster;

@WebServlet("/JdbcQuest")
public class JdbcQuest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JdbcQuest() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Authors tabNames = new Authors();
		List<JediMaster> jediList = new ArrayList<JediMaster>();
		
		jediList = tabNames.getJediMaster();
		String[] jediName = new String[3];
		String[] jediSurname = new String[3];
		
		for(int i = 0; i < jediList.size(); i++ ) {
			jediName[i] = jediList.get(i).getName();
			jediSurname[i] = jediList.get(i).getSurname();
		}


		request.setAttribute( "names", jediName);
		request.setAttribute( "surnames", jediSurname);

		this.getServletContext().getRequestDispatcher("/WEB-INF/lib/authors.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
