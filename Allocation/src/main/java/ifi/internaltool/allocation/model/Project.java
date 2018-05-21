package ifi.internaltool.allocation.model;

import java.time.LocalDate;
import java.util.UUID;


import org.elasticsearch.action.fieldstats.FieldStats.Date;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

//import com.datastax.driver.core.LocalDate;

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
		private LocalDate create_at;
		@Column("end_at")
		private LocalDate end_at;
		
		private String group_name;
		
		
		
		public Project(){
			
		}
		public Project(final UUID project_id, final int group_id, final String desciption, final boolean status , final  LocalDate create_at,final LocalDate end_at) {
			this.project_id=project_id;
			this.group_id=group_id;
			this.desciption= desciption;
			this.status= status;
			this.create_at= create_at;
			this.end_at= end_at;
				
		}
		public String getGroup_name() {
			return group_name;
		}
		public void setGroup_name(String group_name) {
			this.group_name = group_name;
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
		public LocalDate getCreate_at() {
			return create_at;
		}
		public void setCreate_at(LocalDate create_at) {
			this.create_at = create_at;
		}
		public LocalDate getEnd_at() {
			return end_at;
		}
		public void setEnd_at(LocalDate end_at) {
			this.end_at = end_at;
		}
		
				
		
			
		
}
