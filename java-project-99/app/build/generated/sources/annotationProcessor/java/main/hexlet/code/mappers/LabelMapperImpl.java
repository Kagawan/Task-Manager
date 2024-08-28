package hexlet.code.mappers;

import hexlet.code.dto.labels.LabelCreateDTO;
import hexlet.code.dto.labels.LabelDTO;
import hexlet.code.dto.labels.LabelUpdateDTO;
import hexlet.code.model.Label;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-28T11:19:43+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.4 (Ubuntu)"
)
@Component
public class LabelMapperImpl extends LabelMapper {

    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    @Override
    public Label map(LabelCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Label label = new Label();

        label.setName( dto.getName() );

        return label;
    }

    @Override
    public List<LabelDTO> map(List<Label> list) {
        if ( list == null ) {
            return null;
        }

        List<LabelDTO> list1 = new ArrayList<LabelDTO>( list.size() );
        for ( Label label : list ) {
            list1.add( map( label ) );
        }

        return list1;
    }

    @Override
    public LabelDTO map(Label model) {
        if ( model == null ) {
            return null;
        }

        LabelDTO labelDTO = new LabelDTO();

        labelDTO.setId( model.getId() );
        labelDTO.setName( model.getName() );
        if ( model.getCreatedAt() != null ) {
            labelDTO.setCreatedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( model.getCreatedAt() ) );
        }

        return labelDTO;
    }

    @Override
    public void update(LabelUpdateDTO dto, Label model) {
        if ( dto == null ) {
            return;
        }

        if ( jsonNullableMapper.isPresent( dto.getName() ) ) {
            model.setName( jsonNullableMapper.unwrap( dto.getName() ) );
        }
    }
}
