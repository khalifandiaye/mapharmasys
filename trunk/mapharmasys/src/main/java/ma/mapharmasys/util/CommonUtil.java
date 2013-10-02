package ma.mapharmasys.util;

import java.util.Calendar;

import javax.faces.context.FacesContext;

public class CommonUtil {
	
	public static String getReference(){
		String ref = (String) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("commandeRef");
		if (ref == null || "".equals(ref)) {
			ref = "1/" + Calendar.getInstance().get(Calendar.YEAR);
			FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("commandeRef", ref);
		}else{
			String[] reftable = ref.split("/");
			Long count = Long.valueOf(reftable[0]);
			int year = Integer.valueOf(reftable[1]);
			if (year != Calendar.getInstance().get(Calendar.YEAR)){
				ref = "1/" + Calendar.getInstance().get(Calendar.YEAR); 
				FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("commandeRef", ref);
			}
		}
		
		return ref ;
	}
	
	public static Double getDoubleValue(Double value){
		value = value *= 100;
		value = Math.ceil(value);
		value = value /= 100;
		
		return value;
	}

}
