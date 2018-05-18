package ifi.internaltool.allocation.model;

import java.util.UUID;

import org.elasticsearch.action.fieldstats.FieldStats.Date;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
@Table	
public class Project {
	
		@PrimaryKeyColumn(name = "project_id", type = PrimaryKeyType.PARTITIONED)
		private UUID project_id;
	
		@PrimaryKeyColumn(name = "group_id", type = PrimaryKeyType.CLUSTERED)
		private int group_id;
		
		@Column("name")
		@Indexed
		private String name;
		@Column("desciption")
		private String desciption;
		@Column("status")
		private boolean status;
		@Column("create_at")
		private Date create_at;
		@Column("end_at")
		private Date end_at;
		
		
		public Project(){
			
		}
		public Project(final UUID project_id, final int group_id, final String desciption, final boolean status , final  Date create_at,final  Date end_at) {
			this.project_id=project_id;
			this.group_id=group_id;
			this.desciption= desciption;
			this.status= status;
			this.create_at= create_at;
			this.end_at= end_at;
				
		}
		public UUID getProject_id() {
			return project_id;
		}
		public void setProject_id(UUID project_id) {
			this.project_id = project_id;
		}
		public int getGroup_id() {
			return group_id;
		}
		public void setGroup_id(int group_id) {
			this.group_id = group_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDesciption() {
			return desciption;
		}
		public void setDesciption(String desciption) {
			this.desciption = desciption;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public Date getCreate_at() {
			return create_at;
		}
		public void setCreate_at(Date create_at) {
			this.create_at = create_at;
		}
		public Date getEnd_at() {
			return end_at;
		}
		public void setEnd_at(Date end_at) {
			this.end_at = end_at;
		}
				
		
			
		
}
