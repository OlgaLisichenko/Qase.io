package Api.dto.result;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Results {
    int total;
    int filtered;
    int count;
    ArrayList<Object> entities;
}
