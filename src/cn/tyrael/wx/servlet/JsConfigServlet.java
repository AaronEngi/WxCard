package cn.tyrael.wx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.tyrael.data.wx.net.JsConfig;
import cn.tyrael.wx.JsApiTicketManager;
import cn.tyrael.wx.JsSign;

/**
 * Servlet implementation class JsConfigServlet
 */
@WebServlet("/JsConfigServlet")
public class JsConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final JsApiTicketManager ticketManager = JsApiTicketManager.getInstance();

    /**
     * Default constructor. 
     */
    public JsConfigServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		JsSign sign = new JsSign(ticketManager.getTicket());		
		JsConfig j = sign.signForConfig(url);
		String r = new Gson().toJson(j);
		response.getWriter().append(r);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
