package sn.api.gestionauchanspring.web.dto.response;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RestResponse {

    public static Map<String, Object> response(HttpStatus status, Object result, String type) {
        Map<String, Object> response = new HashMap<>();

        response.put("status", status.value());
        response.put("results", result);
        response.put("type", type);

        return response;
    }

    public static Map<String, Object> responsePaginate(
            HttpStatus status,
            Object result,
            int[] pages,
            Integer currentPage,
            Integer totalPages,
            Long totalItems,
            Boolean first,
            Boolean last,
            String type
    ) {
        Map<String, Object> response = response(status, result, type);

        response.put("pages", pages);
        response.put("currentPage", currentPage);
        response.put("totalPages", totalPages);
        response.put("totalItems", totalItems);
        response.put("first", first);
        response.put("last", last);

        return response;
    }

}
