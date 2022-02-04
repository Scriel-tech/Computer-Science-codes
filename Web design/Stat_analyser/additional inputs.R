#This is to select the continent
#selectInput(inputId = "Continent", 
#            choices = unique(owid_covid_data$continent), 
#            label = "Continent",
#            multiple = T),

#This is to select the focus of 
#selectInput(inputId = "analysis_focus",
#            choices = analysis_front,
#            label = "Analysis Front"),

#This is a time slider
# sliderInput(inputId = "Year", 
#             label = "Year", 
#             min = min(as.Date(owid_covid_data$date, "%Y-%m")), 
#             max = max(as.Date(owid_covid_data$date, "%Y-%m")), 
#             value = median(as.Date(owid_covid_data$date, "%Y-%m")),
#             timeFormat = "%Y/%m"),