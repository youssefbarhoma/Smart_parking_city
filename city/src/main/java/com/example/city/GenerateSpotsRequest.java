package com.example.city;

import java.util.List;

public class GenerateSpotsRequest {

    private List<SectionRequest> sections;

    public static class SectionRequest {
        private String label;
        private int spotCount;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getSpotCount() {
            return spotCount;
        }

        public void setSpotCount(int spotCount) {
            this.spotCount = spotCount;
        }
    }

    public List<SectionRequest> getSections() {
        return sections;
    }

    public void setSections(List<SectionRequest> sections) {
        this.sections = sections;
    }
}
