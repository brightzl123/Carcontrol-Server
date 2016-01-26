package com.carcontrol.action;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/control")
public class ControlAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -971858974720873091L;
	
	private String cmd;
	
	
	


	@Action(value = "sendCmd")
	public void sendCmd() throws Exception {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		
//		response.getOutputStream().write(cmd.getBytes("UTF-8"));
		
		
		
	System.out.println("-----------!!!!!!!!!!!!!!!" + cmd);
	
		
		String shName="";
		
		if (cmd.equalsIgnoreCase("A")) {
			shName="A_forward.sh";
		}else if (cmd.equalsIgnoreCase("B")) {
			shName="B_crazy_forward.sh";
		}else if (cmd.equalsIgnoreCase("C")) {
			shName="C_backoff.sh";
		}else if (cmd.equalsIgnoreCase("D")) {
			shName="D_crazy_backoff.sh";
		}else if (cmd.equalsIgnoreCase("E")) {
			shName="E_stop.sh";
		}else if (cmd.equalsIgnoreCase("F")) {
			shName="F_turnleft.sh";
		}else if (cmd.equalsIgnoreCase("G")) {
			shName="G_turnleft_ring.sh";
		}else if (cmd.equalsIgnoreCase("H")) {
			shName="H_turnright.sh";
		}else if (cmd.equalsIgnoreCase("I")) {
			shName="I_turnright_ring.sh";
		}else if (cmd.equalsIgnoreCase("J")) {
			
		}else if (cmd.equalsIgnoreCase("K")) {
			
		}else if (cmd.equalsIgnoreCase("STOP")){
			shName="STOP_stop.sh";
		}
		
		try {
			
			if (shName.length()==0) {
				return;
			}
		 
			
			
			System.out.println("-----------!!!!!!!!!!!!!!!" + "/home/ubuntu/car_control/"+shName);
			
			
			
			 Process process = Runtime.getRuntime().exec(new String[]{"sudo","/home/ubuntu/car_control/"+shName},null,null);  
//			 Process process = Runtime.getRuntime().exec(new String[]{"ls","/hebiao/a/"},null,null);  
		        InputStreamReader ir = new InputStreamReader(process  
		                .getInputStream());  
		        LineNumberReader input = new LineNumberReader(ir);  
		        String line;  
		        process.waitFor();  
		        while ((line = input.readLine()) != null){  
		            System.out.println("--------------------"+line); 
		        }  
		} catch (Exception e) {
			// TODO: handle exception
			 System.out.println("--------------------"+e); 
		}
		

		
	}
	 
	
	@Action(value = "connect")
	public void connect() throws Exception {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		response.getOutputStream().write("OK".getBytes("UTF-8"));
	}
	 
	
	
	
	
	public String getCmd() {
		return cmd;
	}


	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

}
