# Please note that loading xlsx in R is really slow compared to csv
library(xlsx)
population_xls <- read.xlsx("population_total.xlsx", encoding = "UTF-8",stringsAsFactors= F, sheetIndex = 1, as.data.frame = TRUE, header=TRUE)
fertility_xls <- read.xlsx("data_quality_children_per_woman.xlsx", encoding = "UTF-8",stringsAsFactors= F, sheetIndex = 1, as.data.frame = TRUE, header=TRUE)
lifeexp_xls <- read.xlsx("life_expectancy_years.xlsx", encoding = "UTF-8", stringsAsFactors= F, sheetIndex = 1, as.data.frame = TRUE, header=TRUE)

library(RCurl)
library(httr)
set_config( config( ssl_verifypeer = 0L ) )


 
# Load libraries
library(reshape)
library(gapminder)
library(dplyr)
library(ggplot2)

# Create a variable to keep only years 1962 to 2009
myvars <- paste("X", 1962:2009, sep="")
# Create 3 data frame with only years 1962 to 2015
population <- population_xls[c('country',myvars)]
fertility <- fertility_xls[c('country',myvars)]
lifeexp <- lifeexp_xls[c('country',myvars)]
rm(population_xls)
rm(fertility_xls)
rm(lifeexp_xls)

# Use reshape library to move the year dimension as a column
population_m <- melt(population, id=c("country")) 
lifeexp_m <- melt(lifeexp, id=c("country")) 
fertility_m <- melt(fertility, id=c("country"))

# Give a different name to each KPI (e.g. pop, life, fert)
colnames(population_m)[3] <- "pop"
colnames(lifeexp_m)[3] <- "life"
colnames(fertility_m)[3] <- "fert"

# Merge the 3 data frames into one
mydf <- merge(lifeexp_m, fertility_m, by=c("country","variable"), header =T)
mydf <- merge(mydf, population_m, by=c("country","variable"), header =T)

#Remove unnessesary variables
rm(fertility, fertility_m, lifeexp, lifeexp_m, population, population_m)

# The only piece of the puzzle missing is the continent name for each country for the color - use gapminder library to bring it
continent <- gapminder %>% group_by(continent, country) %>% distinct(country, continent)
continent <- data.frame(lapply(continent, as.character), stringsAsFactors=FALSE)
colnames(continent)[1] <- "country"

# Filter out all countries that do not exist in the continent table
mydf_filter <- mydf %>% filter(country %in% unique(continent$country))

# Add the continent column to finalize the data set
mydf_filter <- merge(mydf_filter, continent, by=c("country"), header =T)


#What you are doing is on line 67 onwards
# Do some extra cleaning (e.g. remove N/A lines, remove factors, and convert KPIs into numerical values)
mydf_filter[is.na(mydf_filter)] <- 0
mydf_filter <- data.frame(lapply(mydf_filter, as.character), stringsAsFactors=FALSE)
mydf_filter$variable <- as.integer(as.character(gsub("X","",mydf_filter$variable)))
colnames(mydf_filter)[colnames(mydf_filter)=="variable"] <- "year"

# mydf_filter$pop <- as.character(gsub("M","",mydf_filter$pop))
# a = unlist(sapply(mydf_filter$pop, function(x){ifelse(grepl("k",x), T, F)}))
# mydf_filter$pop <- as.character(gsub("k","",mydf_filter$pop))
# a = unlist(sapply(mydf_filter$pop, function(x){ifelse(grepl("B",x), T, F)}))
# mydf_filter$pop <- ifelse(a, as.double(mydf_filter$pop)*1000, as.double(mydf_filter$pop)*1000000)

for(i in 1:length(mydf_filter$pop))
{
  if(grepl("k", mydf_filter$pop[i]))
  {
    mydf_filter$pop[i] = as.double(as.character(gsub("k","",mydf_filter$pop[i]))) * 1000
  }else if(grepl("M",mydf_filter$pop[i]))
  {
    mydf_filter$pop[i] = as.double(as.character(gsub("M","",mydf_filter$pop[i]))) * 1000000
  }else
  {
    mydf_filter$pop[i] = as.double(as.character(gsub("B","",mydf_filter$pop[i]))) * 1000000000
  }
}


mydf_filter$pop <- round(as.numeric(as.character(mydf_filter$pop))/1000000,1)
mydf_filter$fert <- as.numeric(as.character(mydf_filter$fert))
mydf_filter$life <- as.numeric(as.character(mydf_filter$life))


# Load libraries
library(ggplot2)
library(gganimate)
#library(gifski)
#library(png)
# Add a global theme
theme_set(theme_grey()+ theme(legend.box.background = element_rect(),legend.box.margin = margin(6, 6, 6, 6)) )
# OLD VERSION
# Create the plot with years as frame, limiting y axis from 30 years to 100
# p <- ggplot(mydf_filter, aes(fert, life, size = pop, color = continent, frame = variable)) +
#  geom_point()+ ylim(30,100)  + labs(x="Fertility Rate", y = "Life expectancy at birth (years)", caption = "(Based on data from Hans Rosling - gapminder.com)", color = 'Continent',size = "Population (millions)") + 
#  scale_color_brewer(type = 'div', palette = 'Spectral') 
# gganimate(p, interval = .2, "output.gif")
# NEW VERSION
# Create the plot with years as frame, limiting y axis from 30 years to 100
p <- ggplot(mydf_filter, aes(fert, life, size = pop, color = continent, frame = year)) +
  labs(x="Fertility Rate", y = "Life expectancy at birth (years)", caption = "(Based on data from Hans Rosling - gapminder.com)", color = 'Continent',size = "Population (millions)") + 
  ylim(30,100) +
  geom_point() +
  scale_color_brewer(type = 'div', palette = 'Spectral') + 
  # gganimate code
  ggtitle("Year: {frame_time}") +
  transition_time(year) +
  ease_aes("linear") +
  enter_fade() +
  exit_fade()
# animate
animate(p, width = 450, height = 450)
# save as a GIF
anim_save("output.gif")