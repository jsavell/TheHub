'use strict';

const React = require('react');
const PostList = require('./posts');

React.render(
	<div>
		<div className="element">
			<PostList />
		</div>
	</div>,
	document.getElementById('react')
)

