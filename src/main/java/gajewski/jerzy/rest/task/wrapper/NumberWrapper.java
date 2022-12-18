package gajewski.jerzy.rest.task.wrapper;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter
@Validated
@NoArgsConstructor
public class NumberWrapper {
    @NotNull(message = "List can not be null")
    @Size(min=1, message = "List can not be empty")
    private List<Double> numberList;
    @Pattern(regexp = "^(?i)asc|desc$", message = "Should be ASC or DESC")
    private String sorted;
}
