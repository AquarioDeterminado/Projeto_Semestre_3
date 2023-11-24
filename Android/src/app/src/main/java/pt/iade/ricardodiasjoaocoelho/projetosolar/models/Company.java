package pt.iade.ricardodiasjoaocoelho.projetosolar.models;

public class Company {

        private String name;
        private String address;
        private String email;
        private String phone;
        private String website;
        private String description;
        private String logo;
        private String[] tags;

        public Company(String name, String address, String email, String phone, String website, String description, String logo, String[] tags) {
            this.name = name;
            this.address = address;
            this.email = email;
            this.phone = phone;
            this.website = website;
            this.description = description;
            this.logo = logo;
            this.tags = tags;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String[] getTags() {
            return tags;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getWebsite() {
            return website;
        }

        public String getDescription() {
            return description;
        }

        public String getLogo() {
            return logo;
        }
}
