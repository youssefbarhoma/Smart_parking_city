package com.example.city;

import java.util.List;

public class GenerateSpotsRequest {

    private List<SectionConfig> sections;

    public static class SectionConfig {
        private String sectionName;
        private int spotCount;

        public String getSectionName() {
            return sectionName;
        }

        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }

        public int getSpotCount() {
            return spotCount;
        }

        public void setSpotCount(int spotCount) {
            this.spotCount = spotCount;
        }
    }

    public List<SectionConfig> getSections() {
        return sections;
    }

    public void setSections(List<SectionConfig> sections) {
        this.sections = sections;
    }
}
