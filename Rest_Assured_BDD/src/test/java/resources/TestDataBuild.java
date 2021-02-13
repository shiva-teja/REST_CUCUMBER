package resources;

import java.util.ArrayList;
import java.util.List;
import pojo.Login;
import pojo.Register_user;


public class TestDataBuild {
		public Register_user registeruser() {
			Register_user r=new Register_user();
			r.setEmail("eve.holt@reqres.in");
			r.setPassword("pistol");
			return r;
			
		}
		public Register_user registeruserfail() {
			Register_user r=new Register_user();
			r.setEmail("eve.holt@gmail.in");
			r.setPassword("pistol");
			return r;
			
		}
		public Login loginuser() {
			Login l=new Login();
			l.setEmail("eve.holt@reqres.in");
			l.setPassword("pistol");
			return l;
			
		}
		public Login loginuserfail() {
			Login l=new Login();
			l.setEmail("eve.holt@gmail.in");
			l.setPassword("pistol");
			return l;
			
		}
}
