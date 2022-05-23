using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddDbContext<RunnerDb>(opt => opt.UseInMemoryDatabase("RunnersList"));
builder.Services.AddDbContext<RaceDb>(opt => opt.UseInMemoryDatabase("RacersList"));
builder.Services.AddDbContext<RaceResultDb>(opt => opt.UseInMemoryDatabase("RaceResultList"));
builder.Services.AddDatabaseDeveloperPageExceptionFilter();
var app = builder.Build();

//Custom Get method which will apply to all 3 datasets
/*app.MapGet("/:dataset", async (RunnerDb runDb, RaceDb raceDb, RaceResultDb raceResultDb) => 
{
    if(req)
});*/

//Get Total list of Runners
app.MapGet("/Runners", async (RunnerDb db) =>
    await db.Runners.ToListAsync()
);

//Get a Runner using on their Id
app.MapGet("/Runner/{id}", async (int id, RunnerDb db) =>
    await db.Runners.FindAsync(id)
        is Runner runner
            ? Results.Ok(runner)
            : Results.NotFound()
);

//Get a List of all Races
app.MapGet("/Races", async (RaceDb db) => 
    await db.Races.ToListAsync()
);

//Get a Race using the race id


//Get all Race Results
app.MapGet("/RaceResults", async (RaceResultDb db) => 
    await db.RaceResults.ToListAsync()
);

//Post(Add) a Runner
app.MapPost("/Runner", async (Runner runner, RunnerDb db) => 
{
    db.Runners.Add(runner);
    await db.SaveChangesAsync();

    return Results.Created("/Runner/{runner.id}", runner);
});

//Post(Add) a Race
app.MapPost("/Race", async (Race race, RaceDb db) => 
{
    db.Races.Add(race);
    await db.SaveChangesAsync();

    return Results.Created("/Race/{race.id}", race);
});

//Post(Add) a race's Result
app.MapPost("/RaceResult", async (RaceResult result, RaceResultDb db) =>
{
    db.RaceResults.Add(result);
    await db.SaveChangesAsync();

    return Results.Created("/RaceResult/{results.raceId}",result);
});

//Replace a Runner with new/updated information
app.MapPut("/Runners/{id}", async (int id, Runner inputRunner, RunnerDb db) =>
{
    var runner = await db.Runners.FindAsync(id);
    
    if(runner is null) return Results.NotFound();

    runner.firstName = inputRunner.firstName;
    runner.lastName = inputRunner.lastName;

    await db.SaveChangesAsync();
    return Results.NoContent();
});

app.MapDelete("/Runners/{id}", async (int id, RunnerDb db) => 
{
    if(await db.Runners.FindAsync(id) is Runner runner)
    {
        db.Runners.Remove(runner);
        await db.SaveChangesAsync();
        return Results.Ok(runner);
    }

    return Results.NotFound();
});

app.Run();

class Runner
{
    public string? firstName {get; set; }
    public string? lastName {get; set; }
    public int id {get; set; } 
}

class Race
{
    public string? name {get; set; }
    public decimal distance {get; set; }
    public int id {get; set; }
    public string? location {get; set; }
}

class RaceResult
{
    public int raceId {get; set; }
    public int runnerId {get; set; }
    public int position {get; set; }
    public int[] time = new int [3];
    //Time must be inserted as hour, minute, second.
}

class RunnerDb : DbContext
{
    public RunnerDb(DbContextOptions<RunnerDb> options)
        : base(options) { }
    public DbSet<Runner> Runners => Set<Runner>();
}

class RaceDb : DbContext
{
    public RaceDb(DbContextOptions<RaceDb> options)
        : base(options) { }
    public DbSet<Race> Races => Set<Race>();
}

class RaceResultDb : DbContext
{
    public RaceResultDb(DbContextOptions<RaceResultDb> options)
        : base(options) { }
    public DbSet<RaceResult> RaceResults => Set<RaceResult>();
}