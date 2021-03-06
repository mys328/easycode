package com.easycodebox.common.idgenerator.support;

import com.easycodebox.common.enums.entity.YesNo;
import com.easycodebox.common.lang.Strings;
import com.easycodebox.common.idgenerator.AbstractIdGenerator;

/**
 * @author WangXiaoJin
 * 
 */
public abstract class AbstractStringIdGenerator extends AbstractIdGenerator<String> {
	
	protected String curVal;
	
    protected Integer size;
    
    protected AbstractStringIdGenerator(int increment, int fetchSize, YesNo isCycle) {
		super(increment, fetchSize, isCycle);
	}
	
	/**
     * 比较两个字符窜 a>b返回正数 a==b返回0 a<b返回负数 
     * @param a
     * @param b
     * @return
     */
    public int compare(String a, String b) {
    	String tmpa = filterZero(a);
		String tmpb = filterZero(b);
    	if(tmpa == null && tmpb != null)
    		return -1;
    	else if(tmpa == null && tmpb == null)
    		return 0;
    	else if(tmpa != null && tmpb == null)
    		return 1;
    	else {
    		if(tmpa.length() < tmpb.length())
    			return -1;
    		else if(tmpa.length() == tmpb.length()) {
    			return tmpa.compareToIgnoreCase(tmpb);
    		}else 
    			return 1;
    	}
    }
    
    /**
     * 过滤字符窜前面的0
     * @param val
     * @return
     */
    public String filterZero(String val) {
    	if(Strings.isNotBlank(val))
    		return val.replaceFirst("^0+", "");
    	else
    		return val;
    }
    
}
