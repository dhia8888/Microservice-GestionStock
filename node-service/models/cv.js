const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const cvSchema = new Schema(
    {
      path: String,
      fileName:String,
      raw_data:Schema.Types.Mixed
    },
    { timestamps: true }
  );
  
  module.exports = mongoose.model("cv", cvSchema);
  