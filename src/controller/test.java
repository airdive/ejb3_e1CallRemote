package controller;

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicinterface.SayHelloRemoteTypeRemote;

public class test extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Properties props = new Properties();
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"weblogic.jndi.WLInitialContextFactory");
			props.setProperty(Context.PROVIDER_URL, "t3://localhost:7001");
			props.setProperty(Context.SECURITY_PRINCIPAL, "weblogic");
			props.setProperty(Context.SECURITY_CREDENTIALS, "weblogic12");

			Context context = new InitialContext(props);
			SayHelloRemoteTypeRemote sayHelloRemoteTypeRemoteRef = (SayHelloRemoteTypeRemote) context
					.lookup("sayHelloRemoteTypeJNDI#publicinterface.SayHelloRemoteTypeRemote");
//			.lookup("ejb3_e1EJBejb3_e1EJB_jarSayHelloRemoteType_Home");
			//ejb3_e1EJBejb3_e1EJB_jarSayHelloRemoteType_Home
			//ejb3_e1EJBejb3_e1EJB_jarSayHelloRemoteType_SayHelloRemoteTypeRemote
			sayHelloRemoteTypeRemoteRef.sayHelloMethodRemote();
			context.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
