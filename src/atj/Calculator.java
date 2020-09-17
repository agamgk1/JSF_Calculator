package atj;

import javax.inject.Named; 
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

@Named
@SessionScoped
public class Calculator implements Serializable {
	  private static final long serialVersionUID = -3512401082776903678L;
	  @PostConstruct
	  public void initialize() {
	      System.out.println(Calculator.class.getSimpleName() + " was constructed");
	  }
		private String value1 = "0";
		private String value2 = "0";
		private String display = "0";
		private String action = "";
		private String hide = "false";
		private String backgroundColor = "FloralWhite";
		private String displayBackgroundColor = "rgba(82, 81, 81, 0.7)";
		private String buttonBackgroundColor = "";
		private String displayNumberColor = "white";
		private String fontFamily = "verdana";

	
		public String getValue1() {
			return value1;
		}
		// delete double zero
		public void setValue1(String value1) {
			if (this.value1.length() == 1 && this.value1.substring(0, 1).equals("0") && !value1.equals(".")) {
				this.value1 = "";
			}	
			
			//check if "." was previously selected
			if (value1.equals(".") && this.value1.contains(".")) {
				value1 = "";
			}	
			
			if (action.equals("equals")){
				this.value1 = "";
				action = "";
			}
			this.value1 = this.value1 + value1;
			display = this.value1;
		}

		public String getValue2() {
			return value2;
		}
		
		public void setValu2(String value2) {
			this.value2 = value2;
		}
		
		public String getDisplay() {
			return display;
		}

		public void setDisplay(String display) {
			this.display = display;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

		// add 
		public void add(){
			if (action.equals("equals") || !action.equals(""))
			{ 
				value1 = display;
				}
			action="add";
			value2 = value1;
			display = value1;
			value1 = "0";
		}
		// subtract
		public void subtract(){
			if (action.equals("equals") || !action.equals(""))
			{ 
				value1 = display;
				}
			action="subtract";
			value2 = value1;
			display = value1;
			value1 = "0";
		}
		// multiply
		public void multiply(){
			if (action.equals("equals") || !action.equals(""))
			{ 
				value1 = display;
				}
			action="multiply";
			value2 = value1;
			display = value1;
			value1 = "0";
		}
		// divide
		public void divide(){
			if (action.equals("equals") || !action.equals(""))
				{ 
				value1 = display;
				}
			action= "divide";
			value2 = value1;
			display = value1;
			value1 = "0";
		}
		// sqrt
		public void sqrt(){
			if (action.equals("equals") || !action.equals(""))
			{ 
				value1 = display;
			}
			action = "sqrt";
		}
		
		// percent
		public void percent(){
			if (action.equals("equals") || !action.equals(""))
				{ 
				value1 = display;
				}
			action= "percent";
			value2 = value1;
			display = value1;
			value1 = "0";
		}
		// change sign
		public void changeSign(){
			if (action.equals("equals"))
			{ 
				value1 = display;
				}
			if (!action.equals("")){
				float res = Float.parseFloat(value1) * (-1);
				value1 = "" + res;
				display = value1;
			}
			else{
				action = "changeSign";
				calculate();
			}		
		}
		
		// calculate
		public void calculate(){
			if (action.equals("add")){
				float res = Float.parseFloat(value2) + Float.parseFloat(value1);
				display = ""+res;
			}
			else if (action.equals("subtract")){
				float res = Float.parseFloat(value2) - Float.parseFloat(value1);
				display = ""+res;
			}
			else if (action.equals("multiply")){
				float res = Float.parseFloat(value2) * Float.parseFloat(value1);
				display = ""+res;
			}
			else if (action.equals("divide")){
				if (value1.equals("0")){
					setHide("true");
					display = "ERR";
					}
				else{
					float res = Float.parseFloat(value2) / Float.parseFloat(value1);
					display = ""+res;
				}
			}
			else if (action.equals("sqrt")){
				double res = Float.parseFloat(this.value1);
				
				if (res < 0) {
					setHide("true");
					display = "ERR";
				}
				else{
					display = "" + Math.sqrt(res);
				}
			}
			
			else if(action.equals("percent")) {
				double res = Float.parseFloat(value2) * (Float.parseFloat(value1)/100d);
				display = ""+ res;
			}
			
			else if (action.equals("changeSign")){
				float res = Float.parseFloat(value1) * (-1);
				display = ""+ res;
			}
			action = "equals";
		}
		
		// cancel 
		public void cancel(){
			value1 = "0";
			value2 = "0";
			display = "0";
			action = "";
			setHide("false");
		}
		
		public String getHide() {
			return hide;
		}
		public void setHide(String hide) {
			this.hide = hide;
		}

		public String getBackgroundColor() {
			return backgroundColor;
		}

		public void setBackgroundColor(String backgroundColor) {
			this.backgroundColor = backgroundColor;
		}

		public String getDisplayBackgroundColor() {
			return displayBackgroundColor;
		}

		public void setDisplayBackgroundColor(String displayBackgroundColor) {
			this.displayBackgroundColor = displayBackgroundColor;
		}

		public String getFontFamily() {
			return fontFamily;
		}

		public void setFontFamily(String fontFamily) {
			this.fontFamily = fontFamily;
		}

		public String getDisplayNumberColor() {
			return displayNumberColor;
		}

		public void setDisplayNumberColor(String displayNumberColor) {
			this.displayNumberColor = displayNumberColor;
		}
			
		public String getButtonBackgroundColor() {
			return buttonBackgroundColor;
		}
		public void setButtonBackgroundColor(String buttonBackgroundColor) {
			this.buttonBackgroundColor = buttonBackgroundColor;
		}
		public String openSettingsPage() {
			return "settings";
		}
		public String openIndexPage() {
			return "index";
		}

	}