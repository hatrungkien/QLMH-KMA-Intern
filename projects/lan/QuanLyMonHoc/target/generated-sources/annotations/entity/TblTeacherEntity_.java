package entity;

import com.model.entity.TblAssistantEntity;
import com.model.entity.TblTeacherEntity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TblTeacherEntity.class)
public abstract class TblTeacherEntity_ {

	public static volatile SingularAttribute<TblTeacherEntity, TblAssistantEntity> tblAssistantEntity;
	public static volatile SingularAttribute<TblTeacherEntity, String> name;
	public static volatile SingularAttribute<TblTeacherEntity, Integer> id;

	public static final String TBL_ASSISTANT_ENTITY = "tblAssistantEntity";
	public static final String NAME = "name";
	public static final String ID = "id";

}

