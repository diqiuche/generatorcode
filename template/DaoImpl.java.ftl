package ${model.packageName};

import org.springframework.stereotype.Repository;

import com.ceacsz.pms.core.BaseDaoImpl;
import com.ceacsz.pms.dao.${model.implementsName};
import com.ceacsz.pms.model.${model.changeClass};
/**
 * @Description:Dao µœ÷¿‡
 * @date ${model.sysDate}
 * @author 
 * @version 1.0
 *          <p>
 *          Company:http://www.ceacsz.com.cn
 *          </p>
 *          <p>
 *          Copyright:Copyright(c)2014-2015
 *          </p>
 */
@Repository
public class ${model.className} extends BaseDaoImpl<${model.changeClass}Model> implements I${model.implementsName} {
	

}