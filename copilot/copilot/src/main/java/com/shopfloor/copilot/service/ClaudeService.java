package com.shopfloor.copilot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ClaudeService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public String generatePlan(String situation) {
        try {
            String prompt = """
                You are an expert factory production planner with 20 years of experience.
                A factory supervisor has given you today's situation.
                Generate a clear, practical production plan.
                
                Today's situation:
                """ + situation + """
                
                Respond with a structured plan using this format:
                
                📋 TODAY'S PRODUCTION PLAN
                [List each order with: start time, which machines, how many workers, expected completion]
                
                ⚠️ WATCH OUT FOR:
                [Any risks or issues to monitor]
                
                💡 SUPERVISOR TIP:
                [One key advice for today]
                
                Keep it practical, specific, and under 200 words.
                """;

            String requestBody = """
                {
                    "contents": [
                        {
                            "parts": [
                                {
                                    "text": "%s"
                                }
                            ]
                        }
                    ]
                }
                """.formatted(prompt.replace("\"", "\\\"").replace("\n", "\\n"));

            String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey;            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(
                    request, HttpResponse.BodyHandlers.ofString()
            );

            String body = response.body();

            int start = body.indexOf("\"text\": \"") + 9;
            int end = body.lastIndexOf("\"");
            if (start > 9 && end > start) {
                return body.substring(start, end)
                        .replace("\\n", "\n")
                        .replace("\\\"", "\"");
            }

            return "Could not parse response: " + body;

        } catch (Exception e) {
            return "Error calling Gemini API: " + e.getMessage();
        }
    }
}