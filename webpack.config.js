const merge = require('webpack-merge');
const path = require('path');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

var action = process.env.npm_lifecycle_event;

// Configuration
var config = {
  action: process.env.npm_lifecycle_event,
  mainPath: path.resolve(__dirname, 'src/main'),
  resourcesPath: path.resolve(__dirname, 'src/main/resources'),
  assetsSubDirectory: 'static',
  templatesSubDirectory: 'templates'
};

// Common build configuration
// that will used for every process
var webpackConfig = {
  
  context: config.mainPath,
  
  entry: [
    './stylesheets/index.scss',
    './ux/app.js'
  ],
  
  output: {
    path: path.join(config.resourcesPath, config.assetsSubDirectory), 
    filename: 'js/[name].js'
  },
  
  module: {
    
    rules: [{
      test: /\.scss$/,
      use: ExtractTextPlugin.extract({
        use: [
          'css-loader',
          'sass-loader'
        ]
      })
    }]    
  },
  
  plugins: [    
    new ExtractTextPlugin('css/[name].css')
  ]
};

// Enable hot reload
// while executing `npm run start` command
if ( config.action === 'start' ) {
  
  webpackConfig = merge(webpackConfig, {
    
    watch: true,
    
    plugins: [
      
      new CopyWebpackPlugin([
        {
          context: config.resourcesPath,
          from: path.join(config.resourcesPath, config.assetsSubDirectory, '/**/*'),
          to: path.resolve(__dirname, 'target/classes')
        }, {
          context: config.resourcesPath,
          from: path.join(config.resourcesPath, config.templatesSubDirectory, '/**/*.html'),
          to: path.resolve(__dirname, 'target/classes')
        }
      ])
    ]
  });
}

module.exports = webpackConfig;