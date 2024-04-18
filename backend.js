const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
require('dotenv').config();

// express app init
const app = express();

// Middleware
app.use(express.json()); //parse app/json
app.use(cors()) // enable cors

// May not use mongo, just a json. Frontend will pull random word from words.json
 // Mongo
// mongoose.connect(process.env.MONGODB_URI, {
//     useNewUrlParser: true,
//     useUnifiedTopology: true
// }).then(() => console.log("MongoDB Connected")).catch(err => console.log(err));

// Route to get a word
app.get('/words', (req, res) => {
    getRandomWord((err, word) => {
        if (err) {
            return res.status(500).json({ message: "Failed get", error: err});
        }
        res.json({randomWord: word});
    });
});

// route check status
app.get('/status', (req, res) => {
    res.json({message: 'Backend is gtg'});
});

// Start server
const PORT = process.env.PORT || 4040;
app.listen(PORT, () => console.log('server running on port ${PORT}'));
// Terminal type "node Backend.js" and then Go to http://localhost:4040/status to check
