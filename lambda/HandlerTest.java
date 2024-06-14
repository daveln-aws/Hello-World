package com.example.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class HandlerTest {

    @Test
    public void testHandleRequest() {
        // Mock the input stream and context
        ByteArrayInputStream inputStream = new ByteArrayInputStream("test image data".getBytes());
        Context context = Mockito.mock(Context.class);

        // Call the Lambda function
        Handler handler = new Handler();
        String result = handler.handleRequest(inputStream, context);

        // Verify the result
        assertEquals("Image uploaded successfully", result);
    }
}
