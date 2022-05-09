module.exports = {
  devServer: {
    port: 8081
  },
  // filenameHashing: false
  configureWebpack: {
    module: {
      rules: [
        {
          test: /easy-ring-default\.(wav)$/i,
          loader: 'file-loader',
          options: {
            name: 'media/[name].[ext]'
          }
        }
      ]
    }
  }
}
