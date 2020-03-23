package com.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_teacher", schema = "demo", catalog = "")
public class TblTeacherEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Basic@Column(name = "name", nullable = false, length = 255)
    private String name;

    //map voi class
    @ManyToMany(mappedBy = "tblTeacherEntities")
    private Set<TblClassEntity> ClassEntities;

    public TblTeacherEntity() {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Set<TblClassEntity> getClassEntities() {
        return this.ClassEntities;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassEntities(Set<TblClassEntity> ClassEntities) {
        this.ClassEntities = ClassEntities;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TblTeacherEntity)) return false;
        final TblTeacherEntity other = (TblTeacherEntity) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$ClassEntities = this.getClassEntities();
        final Object other$ClassEntities = other.getClassEntities();
        if (this$ClassEntities == null ? other$ClassEntities != null : !this$ClassEntities.equals(other$ClassEntities))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TblTeacherEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $ClassEntities = this.getClassEntities();
        result = result * PRIME + ($ClassEntities == null ? 43 : $ClassEntities.hashCode());
        return result;
    }

    public String toString() {
        return "TblTeacherEntity(id=" + this.getId() + ", name=" + this.getName() + ", ClassEntities=" + this.getClassEntities() + ")";
    }
}
