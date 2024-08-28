package hexlet.code.mappers;

import hexlet.code.dto.tasks.TaskCreateDTO;
import hexlet.code.dto.tasks.TaskDTO;
import hexlet.code.dto.tasks.TaskUpdateDTO;
import hexlet.code.model.Task;
import hexlet.code.model.TaskStatus;
import hexlet.code.model.User;
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
public class TaskMapperImpl extends TaskMapper {

    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    @Override
    public Task map(TaskCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Task task = new Task();

        task.setAssignee( assigneeIdToUser( dto.getAssigneeId() ) );
        task.setName( dto.getTitle() );
        task.setDescription( dto.getContent() );
        task.setTaskStatus( slugToTaskStatus( dto.getStatus() ) );
        task.setLabels( labelIdToLabel( dto.getTaskLabelIds() ) );
        task.setIndex( dto.getIndex() );

        return task;
    }

    @Override
    public TaskDTO map(Task model) {
        if ( model == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setAssigneeId( modelAssigneeId( model ) );
        taskDTO.setTitle( model.getName() );
        taskDTO.setContent( model.getDescription() );
        taskDTO.setStatus( modelTaskStatusSlug( model ) );
        taskDTO.setTaskLabelIds( labelsToLabelsIds( model.getLabels() ) );
        taskDTO.setId( model.getId() );
        taskDTO.setIndex( model.getIndex() );
        if ( model.getCreatedAt() != null ) {
            taskDTO.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( model.getCreatedAt() ) );
        }

        return taskDTO;
    }

    @Override
    public void update(TaskUpdateDTO dto, Task model) {
        if ( dto == null ) {
            return;
        }

        if ( jsonNullableMapper.isPresent( dto.getAssigneeId() ) ) {
            model.setAssignee( assigneeIdToUser( jsonNullableMapper.unwrap( dto.getAssigneeId() ) ) );
        }
        if ( jsonNullableMapper.isPresent( dto.getTitle() ) ) {
            model.setName( jsonNullableMapper.unwrap( dto.getTitle() ) );
        }
        if ( jsonNullableMapper.isPresent( dto.getContent() ) ) {
            model.setDescription( jsonNullableMapper.unwrap( dto.getContent() ) );
        }
        if ( jsonNullableMapper.isPresent( dto.getStatus() ) ) {
            model.setTaskStatus( slugToTaskStatus( jsonNullableMapper.unwrap( dto.getStatus() ) ) );
        }
        if ( model.getLabels() != null ) {
            if ( jsonNullableMapper.isPresent( dto.getTaskLabelIds() ) ) {
                model.getLabels().clear();
                model.getLabels().addAll( labelIdToLabel( jsonNullableMapper.unwrap( dto.getTaskLabelIds() ) ) );
            }
        }
        else {
            if ( jsonNullableMapper.isPresent( dto.getTaskLabelIds() ) ) {
                model.setLabels( labelIdToLabel( jsonNullableMapper.unwrap( dto.getTaskLabelIds() ) ) );
            }
        }
        if ( jsonNullableMapper.isPresent( dto.getIndex() ) ) {
            model.setIndex( jsonNullableMapper.unwrap( dto.getIndex() ) );
        }
    }

    private Long modelAssigneeId(Task task) {
        if ( task == null ) {
            return null;
        }
        User assignee = task.getAssignee();
        if ( assignee == null ) {
            return null;
        }
        long id = assignee.getId();
        return id;
    }

    private String modelTaskStatusSlug(Task task) {
        if ( task == null ) {
            return null;
        }
        TaskStatus taskStatus = task.getTaskStatus();
        if ( taskStatus == null ) {
            return null;
        }
        String slug = taskStatus.getSlug();
        if ( slug == null ) {
            return null;
        }
        return slug;
    }
}
