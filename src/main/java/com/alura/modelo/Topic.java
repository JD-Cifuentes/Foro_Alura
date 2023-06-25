package com.alura.modelo;

import com.alura.modelo.dto.TopicRegisterData;
import com.alura.modelo.enums.TopicStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Topic")
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String message;

	private LocalDateTime creationDate = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private TopicStatus status = TopicStatus.UNSOLVED;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable=false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable=false)
	private Course course;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private List<Answer> answers = new ArrayList<>();

	public Topic(TopicRegisterData topicRegisterData) {
		this.title = topicRegisterData.title();
		this.message = topicRegisterData.message();
		setUserAndCourseByIds(topicRegisterData.userId(), topicRegisterData.courseId());
	}

	private void setUserAndCourseByIds(Long userId, Long courseId) {
		//todo implementar cuerpo que permita buscar el usuario y el curso
		// por sus reespectivos ID en la base de datos y
		// agregarolos al objeto
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
