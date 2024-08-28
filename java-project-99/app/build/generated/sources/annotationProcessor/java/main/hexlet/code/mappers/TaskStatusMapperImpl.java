package hexlet.code.mappers;

import hexlet.code.dto.taskStatuses.TaskStatusCreateDTO;
import hexlet.code.dto.taskStatuses.TaskStatusDTO;
import hexlet.code.dto.taskStatuses.TaskStatusUpdateDTO;
import hexlet.code.model.TaskStatus;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T11:19:43+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.4 (Ubuntu)"
)
@Component
public class TaskStatusMapperImpl extends TaskStatusMapper {

    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    @Override
    public TaskStatus map(TaskStatusCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TaskStatus taskStatus = new TaskStatus();

        taskStatus.setName( dto.getName() );
        taskStatus.setSlug( dto.getSlug() );

        return taskStatus;
    }

    @Override
    public TaskStatusDTO map(TaskStatus model) {
        if ( model == null ) {
            return null;
        }

        TaskStatusDTO taskStatusDTO = new TaskStatusDTO();

        taskStatusDTO.setId( model.getId() );
        taskStatusDTO.setName( model.getName() );
        taskStatusDTO.setSlug( model.getSlug() );
        if ( model.getCreatedAt() != null ) {
            taskStatusDTO.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( model.getCreatedAt() ) );
        }

        return taskStatusDTO;
    }

    @Override
    public void update(TaskStatusUpdateDTO dto, TaskStatus model) {
        if ( dto == null ) {
            return;
        }

        if ( jsonNullableMapper.isPresent( dto.getName() ) ) {
            model.setName( jsonNullableMapper.unwrap( dto.getName() ) );
        }
        if ( jsonNullableMapper.isPresent( dto.getSlug() ) ) {
            model.setSlug( jsonNullableMapper.unwrap( dto.getSlug() ) );
        }
    }
}
