rm(list = ls())

library(Hmisc)
library(dplyr)
library(ggplot2)
library(readr)
library(shinythemes)



path = "C:/Users/user/Desktop/Coursework/4th Year 2021/Biostatistics/Assignment 1/"
owid_covid_data <- read_csv(paste0(path,"owid-covid-data.csv"))

plots = c("line","point")
#analysis_front = c("by Country","by Time","by Continent")


#Extracting date elements
date = as.Date(owid_covid_data$date)
date_year = format(date, "%Y")
date_month = format(date, "%m")
date_year_month = unique(format(date,"%Y/%m"))

#Extracting variables
exceptions = c("iso_code","continent","location","date")
var = names(owid_covid_data)
var = var[var %nin% exceptions]
address = "https://www.un.org/sites/un2.un.org/files/field/image/1583952355.1997.jpg"

library(shiny)


ui = navbarPage(
  theme = shinytheme("slate"),
  #inverse = F, 
  # App Title
  id = "nav_panel",
  tags$div(tags$img(src=address, width = 130, height = 100, style="float:left; margin-left: 5px; margin-right: 5px; margin-top: -15px")), 
  #tags$style(type = "text/css", ".nav_panel {background-color: navy;}"),
  
  tabPanel(
        "Time Series Analysis",
        tags$br(style = "line-height: 160%;"),
        
        fluidRow(
            column(
                  6,
                 offset = 3,
                 tags$p("The purpose of this page is to show a time-series of a variable for the selected countries. You are able to also derive monthly averages.")
            )
                
        ),
    #Inputs
        fluidRow(
          #Divide this row into 2 pieces 3/9
          #The 3_piece is for the inputs and the 9_piece is for the plot
        
            column(4,
                wellPanel(
                     style = "background-color: #fff; border-color: #2c3e50; height: 350px;",
                     fluidRow(
                       column(
                          12,
                          #This is to select the country
                          selectInput(inputId = "Countries",
                                       choices = unique(owid_covid_data$location),
                                       label = "Location",
                                       multiple = T)
                        )
                     ),
                     fluidRow(
                       column(
                          12,
                          #This is to select the plot type
                          selectInput(inputId = "plot_type",
                                      choices = plots,
                                      label = "Plot type")
                        )
                     ),
                     fluidRow(
                       column(
                          12,
                          #This is to select one variable
                          selectInput(inputId = "var_select",
                                      label = "Variables: ",
                                      choices = var)
                        )
                     ),
                     fluidRow(
                        column(
                          12,
                          #This is to select a period
                          sliderInput(inputId = "series_period",
                                      label = "Years",
                                      min = as.Date(min(date),"%Y-%m"),
                                      max = as.Date(max(date),"%Y-%m"),
                                      value=c(as.Date(min(date)), as.Date(max(date))),
                                      timeFormat="%Y-%m"
                                      )
                        )
                     ),

                     
                     fluidRow(
                       column(
                          12,
                          #This will ask it to use monthly averages
                          checkboxInput(inputId = "use_monthly_data",
                                        label = "Use monthly averages:")
                          )
                     )
                )
            ),
            
            column(8,
                wellPanel(
                  style = "background-color: #fff; border-color: #2c3e50; height: 450px;",
                  fluidRow(
                    plotOutput(outputId = "plot"),
                  )
                   
                )
            )

        )
          
  ),
  
  tabPanel(
      "Summaries",
      
      tags$br(style = "line-height: 160%;"),
      
  ),
  
  tabPanel(
      "Data",
      
      tags$br(style = "line-height: 160%;"),
      
      navbarPage(
          tabPanel(
              "View",
              
            
          ),
          
          tabPanel(
              "Modify",
            
          )
      )
      
  )
  
)



server = function(input, output)
{

  #Subset data
  selected_data <- reactive(
    {
      req(input$Countries)
      req(input$var_select)
      req(input$plot_type)

      data = owid_covid_data %>%
        filter(location %in% as.vector(input$Countries)) %>%
        mutate(month = format(date, "%Y-%m")) %>%
        #filter(as.Date(date,"%Y-%m") > input$series_period[1] & as.Date(date,"%Y-%m") <input$series_period[2]) %>% 
        select(location, date, variable = input$var_select, month)
      
      
      if(input$use_monthly_data)
      {
          data = data %>% 
                group_by(location, month) %>% 
                mutate(variable = mean(variable), location = unique(location), date = date) %>%
                distinct()
      }
      data
    })
  
  
  output$plot <- renderPlot({
    final_plot = ggplot(data = selected_data(), 
                        aes(x = date, 
                            y = variable, 
                            color = location)) +
                ggtitle(paste("Time series plot of", input$var_select, "from", input$series_period[1],"to",input$series_period[2])) + 
                #ggtitle(paste("Time series plot of", input$var_select, "from", min(format(owid_covid_data$date, "%Y-%m")),"to",max(format(owid_covid_data$date, "%Y-%m")))) + 
                xlab("Date") + 
                ylab(input$var_select) +
                theme_bw()

    #ggplot(data = selected_data(), aes(x = date, y = variable, color = location)) + geom_point()
        
    if(input$plot_type == "line")
    {
      final_plot = final_plot + geom_line()
    }else if(input$plot_type == "point")
    {
      final_plot = final_plot + geom_point()
    }
    final_plot
  })
}

shinyApp(ui = ui, server = server)