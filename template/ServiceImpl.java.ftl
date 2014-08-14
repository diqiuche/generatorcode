package ${model.packageName};

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ceacsz.pms.common.PageModel;
import com.ceacsz.pms.common.Page;
import com.ceacsz.pms.dao.${model.changeClass}Dao;
import com.ceacsz.pms.model.${model.changeClass};
import com.ceacsz.pms.service.${model.changeClass}Service;

/**
 * @Description:Service
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
@Service
public class ${model.changeClass}ServiceImpl implements I${model.implementsName} {
	@Resource
	private I${model.changeClass}Dao ${model.lowChangeClass}Dao;

	@Override
	public int insert(${model.changeClass}Model o) throws Exception {
		o.setCreateTime(new Date());
		${model.lowChangeClass}Dao.insert(o);
		return o.get${model.changeClass}Id();
	}

	@Override
	public int update(${model.changeClass}Model o) throws Exception {
		o.setUpdateTime(new Date());
		return ${model.lowChangeClass}Dao.update(o);
	}

	@Override
	public void delete(Integer id) throws Exception {
		${model.lowChangeClass}Dao.delete(id);
	}

	@Override
	public ${model.changeClass}Model getOneById(Integer id) throws Exception {
		${model.changeClass}Model ${model.lowChangeClass} = ${model.lowChangeClass}Dao.getOneById(id);
		return ${model.lowChangeClass};
	}

	@Override
	public PageModel<${model.changeClass}Model> getPageModel(${model.changeClass}Model o, Page page)
			throws Exception {
		PageModel<${model.changeClass}Model> pm = ${model.lowChangeClass}Dao.getPageModelByPage(o, page);
		return pm;
	}

	@Override
	public List<${model.changeClass}Model> getAll(${model.changeClass}Model o) throws Exception {
		return this.${model.lowChangeClass}Dao.getAll(o);

	}
}
